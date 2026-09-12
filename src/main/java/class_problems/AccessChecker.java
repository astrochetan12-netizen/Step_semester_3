public class AccessChecker {

    public static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier == null || accessorContext == null) {
            return "DENIED";
        }

        String mod = fieldModifier.trim().toLowerCase();
        String ctx = accessorContext.trim();

        switch (mod) {
            case "public":
                return "ALLOWED";

            case "protected":
                if (ctx.equals("SAME_CLASS") || ctx.equals("SAME_PACKAGE") ||
                    ctx.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "default":
                if (ctx.equals("SAME_CLASS") || ctx.equals("SAME_PACKAGE")) {
                    return "ALLOWED";
                }
                return "DENIED";

            case "private":
                if (ctx.equals("SAME_CLASS")) {
                    return "ALLOWED";
                }
                return "DENIED";

            default:
                return "DENIED";
        }
    }

    public static String summarizeBatch(String[][] attempts) {
        int allowed = 0;
        int denied = 0;

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String result = classifyAccess(attempt[0], attempt[1]);
                    if ("ALLOWED".equals(result)) {
                        allowed++;
                    } else {
                        denied++;
                    }
                }
            }
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {
        System.out.println("classifyAccess(\"private\", \"SAME_CLASS\"): " +
                classifyAccess("private", "SAME_CLASS"));
        System.out.println("classifyAccess(\"protected\", \"DIFFERENT_PACKAGE\"): " +
                classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE\"): " +
                classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"));
        System.out.println("classifyAccess(\"protected\", \"SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE\"): " +
                classifyAccess("protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"));

        String[][] batch = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeBatch(batch));
    }
}