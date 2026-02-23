import java.util.*;

public class InvoiceData {
    public final String invoiceId;
    public final String customerType;
    public final List<OrderLine> lines;
    public final double subtotal;
    public final double taxPercent;
    public final double tax;
    public final double discount;
    public final double total;

    public InvoiceData(String invoiceId, String customerType, List<OrderLine> lines,
                       double subtotal, double taxPercent, double tax, double discount, double total) {
        this.invoiceId = invoiceId;
        this.customerType = customerType;
        this.lines = lines;
        this.subtotal = subtotal;
        this.taxPercent = taxPercent;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}