public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog audit) { super(audit); }

    @Override
    protected void deliver(Notification n) {
        System.out.println("SMS -> to=" + n.phone + " body=" + n.body);
    }

    @Override
    protected String auditEntry() {
        return "sms sent";
    }
}
