public abstract class NotificationSender {
    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) { this.audit = audit; }

    // Contract: accepts any non-null Notification; channel-specific validation may throw.
    public final void send(Notification n) {
        if (n == null) {
            throw new IllegalArgumentException("notification required");
        }
        validate(n);
        deliver(n);
        audit.add(auditEntry());
    }

    // Subclasses override when a channel requires validation.
    protected void validate(Notification n) { }

    protected abstract void deliver(Notification n);

    protected abstract String auditEntry();
}
