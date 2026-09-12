import java.util.Arrays;

public class CirculationLedger {

    static String branchCode;

    static {
        branchCode = "PT-MAIN";
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts != null) {
            for (LoanReceipt r : receipts) {
                if (r == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (r instanceof ReferenceOnlyLoanReceipt) {
                        referenceOnly++;
                    } else {
                        regular++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " + referenceOnly + " reference-only | " + regular + " regular";
    }

    public static void main(String[] args) {
        LoanReceipt r = new LoanReceipt("LIB-8841", new String[]{"BK-100", "BK-101"});
        String[] ids = r.getBookIds();
        ids[0] = "HACKED";
        System.out.println("Defensive copy test: " + r.getBookIds()[0]);

        LoanReceipt corrected = r.withCorrectedBookId(1, "BK-102");
        System.out.println("Original:  " + Arrays.toString(r.getBookIds()));
        System.out.println("Corrected: " + Arrays.toString(corrected.getBookIds()));

        LoanReceipt[] batch = {
            new ReferenceOnlyLoanReceipt("LIB-001", new String[]{"BK-200"}, "Reading Room 3"),
            null,
            new LoanReceipt("LIB-002", new String[]{"BK-201"})
        };
        System.out.println(processNightlyCirculation(batch));
    }
}