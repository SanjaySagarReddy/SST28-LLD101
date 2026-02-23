public class InvoiceFormatter {
    public String format(InvoiceData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(data.invoiceId).append("\n");
        for (String line : data.lineItems) {
            sb.append(line).append("\n");
        }
        sb.append(String.format("Subtotal: %.2f\n", data.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", data.taxPercent, data.tax));
        sb.append(String.format("Discount: -%.2f\n", data.discount));
        sb.append(String.format("TOTAL: %.2f\n", data.total));
        return sb.toString();
    }
}