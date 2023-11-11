package com.proyectoh.pc2.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice_details", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"invoice_id", "product_id"}),
        @UniqueConstraint(columnNames = {"invoice_id", "product_id", "color"}),
        @UniqueConstraint(columnNames = {"invoice_id", "product_id", "size"})
})
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Long detailId;

    @Column(name = "invoice_id", nullable = false)
    private Long invoiceId;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_description", nullable = false, length = 50)
    private String productDescription;

    @Column(name = "color", length = 15)
    private String color;

    @Column(name = "size", length = 5)
    private String size;

    @Column(name = "payment_date", nullable = false)
    private Time paymentDate;

    @Column(name = "price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "quantity", nullable = false)
    private int quantity;
}
