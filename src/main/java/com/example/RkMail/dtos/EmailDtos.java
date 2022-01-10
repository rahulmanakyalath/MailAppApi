package com.example.RkMail.dtos;

public class EmailDtos {
    String receiverMailId;
    String subject;
    String body;
    String attachment;

    public EmailDtos() {
    }

    public EmailDtos(String receiverMailId, String subject, String body,String attachment) {
        this.receiverMailId = receiverMailId;
        this.subject = subject;
        this.body = body;
        this.attachment=attachment;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getReceiverMailId() {
        return receiverMailId;
    }

    public void setReceiverMailId(String receiverMailId) {
        this.receiverMailId = receiverMailId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "EmailDtos{" +
                "receiverMailId='" + receiverMailId + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachment='" + attachment + '\'' +
                '}';
    }
}
