public class LibraryMember {

    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    private String membershipId;
    private String name;
    private boolean premiumMember;
    private String securityAnswer;
    private boolean membershipIdSet = false;

    public LibraryMember() {
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        if (!membershipIdSet) {
            this.membershipId = membershipId;
            this.membershipIdSet = true;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String securityAnswer) {
        if (securityAnswer != null) {
            this.securityAnswer = "HASH:" + securityAnswer.hashCode();
        }
    }

    public static void main(String[] args) {
        LibraryMember m = new LibraryMember();
        m.setMembershipId("LIB-8841");
        m.setName("Priya Nair");
        m.setPremiumMember(true);
        System.out.println("Membership ID: " + m.getMembershipId());

        m.setMembershipId("FAKE-0000");
        System.out.println("Membership ID after re-set: " + m.getMembershipId());
        System.out.println("isPremiumMember: " + m.isPremiumMember());

        m.setSecurityAnswer("BlueMountain");
        System.out.println("Security answer set (write-only verified).");
    }
}
