package eu.javeo.training.java8.exercises;

import eu.javeo.training.java8.data.Data;
import eu.javeo.training.java8.data.model.Invoice;
import eu.javeo.training.java8.data.model.InvoiceItem;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class Ex6_HighestValueInvoice {

    private double findHighestInvoiceSum(List<Invoice> invoices) {
        // TODO: Zwróć najwyższą wartość faktury // Done!
        return invoices.stream()
                .mapToDouble(this::getInvoiceTotalPrice)
                .max().getAsDouble();
    }

    private double getInvoiceTotalPrice(Invoice invoice){
        double total = 0;
        for(InvoiceItem initem : invoice.getItems()){
            total+= initem.getProduct().getPrice() * initem.getQuantity();
        }
        return total;
    }

    @Test
    public void test() {
        double highestInvoiceSum = findHighestInvoiceSum(Data.invoices);
        assertThat(highestInvoiceSum, is(37550.0)); //three drones five tablets
    }

}
