import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoicePersistence persistence;
    private final BillingCalculator calculator;
    private final InvoiceBuilder invoiceBuilder;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoicePersistence persistence) {
        this.persistence = persistence;
        this.calculator = new BillingCalculator(menu);
        this.invoiceBuilder = new InvoiceBuilder(calculator);
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);

        double subtotal = calculator.calculateSubtotal(lines);
        
        double taxPct = TaxRules.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        
        double discount = DiscountRules.discountAmount(customerType, subtotal, lines.size());
        
        double total = subtotal + tax - discount;

        InvoiceData data = new InvoiceData(invId, customerType, lines, subtotal, taxPct, tax, discount, total);
        String invoiceText = invoiceBuilder.buildInvoiceText(data);

        System.out.print(invoiceText);

        persistence.save(invId, invoiceText);
        System.out.println("Saved invoice: " + invId + " (lines=" + persistence.countLines(invId) + ")");
    }
}