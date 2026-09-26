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

    public static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowed = new int[4];
        int[] denied = new int[4];

        if (attempts != null) {
            for (String[] attempt : attempts) {
                if (attempt != null && attempt.length >= 2) {
                    String mod = attempt[0].trim().toLowerCase();
                    String ctx = attempt[1].trim();
                    String result = classifyAccess(mod, ctx);

                    int idx = -1;
                    for (int i = 0; i < modifiers.length; i++) {
                        if (modifiers[i].equals(mod)) {
                            idx = i;
                            break;
                        }
                    }

                    if (idx != -1) {
                        if ("ALLOWED".equals(result)) {
                            allowed[idx]++;
                        } else {
                            denied[idx]++;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            sb.append(modifiers[i]).append(": ")
              .append(allowed[i]).append(" allowed / ")
              .append(denied[i]).append(" denied");
            if (i < modifiers.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static String firstDeniedAttempt(String[][] attempts) {
        if (attempts == null) {
            return "None Denied";
        }

        for (int i = 0; i < attempts.length; i++) {
            String[] attempt = attempts[i];
            if (attempt != null && attempt.length >= 2) {
                String mod = attempt[0];
                String ctx = attempt[1];
                if ("DENIED".equals(classifyAccess(mod, ctx))) {
                    return mod + " via " + ctx + " (attempt #" + (i + 1) + ")";
                }
            }
        }

        return "None Denied";
    }

    public static void main(String[] args) {
        System.out.println("classifyAccess(\"private\", \"SAME_CLASS\"): " +
                classifyAccess("private", "SAME_CLASS"));
        System.out.println("classifyAccess(\"protected\", \"DIFFERENT_PACKAGE\"): " +
                classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] batch = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };
        System.out.println(summarizeByModifier(batch));

        String[][] attempts1 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println("First denied: " + firstDeniedAttempt(attempts1));

        String[][] attempts2 = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };
        System.out.println("First denied: " + firstDeniedAttempt(attempts2));
    }
}
