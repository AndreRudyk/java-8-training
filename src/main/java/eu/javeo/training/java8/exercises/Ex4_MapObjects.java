package eu.javeo.training.java8.exercises;

import eu.javeo.training.java8.data.Data;
import eu.javeo.training.java8.data.model.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static eu.javeo.training.java8.data.Data.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class Ex4_MapObjects {

    private List<Invoice> toInvoice(List<Order> orders) {
        // TODO: Przekształć zamówienia na faktury // Done!
        return orders.stream()
                .map(this::getItemFromOrders)
                .collect(Collectors.toList());
    }

    private List<InvoiceItem> orderToInvoiceItem(Map<Product, Integer> products){
        List<InvoiceItem> invoiceItems = new ArrayList<>();

        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            invoiceItems.add(new InvoiceItem(entry.getKey(), entry.getValue()));
        }

        return invoiceItems;
    }

    private Invoice getItemFromOrders(Order order){
        return new Invoice(null, order.getOrderDate(), order.getUser(),orderToInvoiceItem(order.getProducts()));
    }

    @Test
    public void test() {
        List<Invoice> invoices = toInvoice(Data.orders);
        assertThat(invoices.get(0).getItems().size(), is(2));
        assertThat(invoices.get(0).getUser(), is(userJaroslawPsikuta));
        assertThat(invoices.get(1).getItems().size(), is(1));
        assertThat(invoices.get(1).getUser(), is(userWaldemarKilof));
        assertThat(invoices.get(2).getItems().size(), is(2));
        assertThat(invoices.get(2).getUser(), is(userAntoniSzpadel));
        assertThat(invoices.get(3).getItems().size(), is(1));
        assertThat(invoices.get(3).getUser(), is(userLeopoldKozibak));
        assertThat(invoices.get(4).getItems().size(), is(4));
        assertThat(invoices.get(4).getUser(), is(userRomualdDzik));
        assertThat(invoices.get(5).getItems().size(), is(1));
        assertThat(invoices.get(5).getUser(), is(userJaroslawPsikuta));
        assertThat(invoices.get(6).getItems().size(), is(2));
        assertThat(invoices.get(6).getUser(), is(userZygfrydWiadro));
        assertThat(invoices.get(7).getItems().size(), is(1));
        assertThat(invoices.get(7).getUser(), is(userRomualdDzik));
        assertThat(invoices.get(8).getItems().size(), is(2));
        assertThat(invoices.get(8).getUser(), is(userJaroslawPsikuta));
        assertThat(invoices.get(9).getItems().size(), is(2));
        assertThat(invoices.get(9).getUser(), is(userAntoniSzpadel));
        assertThat(invoices.get(10).getItems().size(), is(1));
        assertThat(invoices.get(10).getUser(), is(userJaroslawPsikuta));
    }
}
