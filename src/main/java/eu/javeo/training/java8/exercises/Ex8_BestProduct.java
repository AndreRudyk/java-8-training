package eu.javeo.training.java8.exercises;

import eu.javeo.training.java8.data.Data;
import eu.javeo.training.java8.data.model.Invoice;
import eu.javeo.training.java8.data.model.InvoiceItem;
import eu.javeo.training.java8.data.model.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static eu.javeo.training.java8.data.Data.prodPrinter;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class Ex8_BestProduct {

    private Optional<Product> bestProduct(List<Invoice> invoices) {
        // TODO: Zwróć najczęściej kupowany produkt // Done!
        Comparator<InvoiceItem> comparator = (i1, i2)-> Integer.valueOf(i1.getQuantity()).compareTo(Integer.valueOf(i2.getQuantity()));
        return Optional.ofNullable(invoices.stream()
                .flatMap(s -> s.getItems().stream())
                .max(comparator)
                .get()
                .getProduct());

    }

    @Test
    public void test() {
        Optional<Product> bestProduct = bestProduct(Data.invoices);
        assertThat(bestProduct, is(Optional.of(prodPrinter)));
    }

}
