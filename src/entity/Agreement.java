package entity;

public class Agreement {
    private int agreementId;
    private String partyA;
    private int normalIdInAgreement;
    private String partyB;
    private int tutorIdInAgreement;
    private String subject;
    private String address;
    private String freeTime;
    private int totalFee;

    public Agreement() {
    }

    public Agreement(int agreementId, String partyA, int normalIdInAgreement, String partyB, int tutorIdInAgreement, String subject, String address, String freeTime, int totalFee) {
        this.agreementId = agreementId;
        this.partyA = partyA;
        this.normalIdInAgreement = normalIdInAgreement;
        this.partyB = partyB;
        this.tutorIdInAgreement = tutorIdInAgreement;
        this.subject = subject;
        this.address = address;
        this.freeTime = freeTime;
        this.totalFee = totalFee;
    }

    public int getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(int agreementId) {
        this.agreementId = agreementId;
    }

    public String getPartyA() {
        return partyA;
    }

    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    public String getPartyB() {
        return partyB;
    }

    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFreeTime() {
        return freeTime;
    }

    public void setFreeTime(String freeTime) {
        this.freeTime = freeTime;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getNormalIdInAgreement() {
        return normalIdInAgreement;
    }

    public void setNormalIdInAgreement(int normalIdInAgreement) {
        this.normalIdInAgreement = normalIdInAgreement;
    }

    public int getTutorIdInAgreement() {
        return tutorIdInAgreement;
    }

    public void setTutorIdInAgreement(int tutorIdInAgreement) {
        this.tutorIdInAgreement = tutorIdInAgreement;
    }
}