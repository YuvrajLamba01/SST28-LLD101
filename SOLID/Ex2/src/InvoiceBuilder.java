public class InvoiceBuilder {
    private final BillingCalculator calculator;

    public InvoiceBuilder(BillingCalculator calculator) {
        this.calculator = calculator;
    }

    public String buildInvoiceText(InvoiceData data) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(data.invoiceId).append("\n");

        for (OrderLine l : data.lines) {
            MenuItem item = calculator.getMenuItem(l.itemId);
            double lineTotal = calculator.calculateLineTotal(l);
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        out.append(String.format("Subtotal: %.2f\n", data.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", data.taxPercent, data.tax));
        out.append(String.format("Discount: -%.2f\n", data.discount));
        out.append(String.format("TOTAL: %.2f\n", data.total));

        return out.toString();
    }
}