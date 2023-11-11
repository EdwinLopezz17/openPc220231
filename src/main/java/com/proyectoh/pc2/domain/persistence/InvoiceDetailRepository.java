package com.proyectoh.pc2.domain.persistence;

import com.proyectoh.pc2.domain.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
    boolean existsByInvoiceIdAndProductId(Long invoiceId, Long productId);
    boolean existsByInvoiceIdAndProductIdAndColor(Long invoiceId, Long productId, String color);
    boolean existsByInvoiceIdAndProductIdAndSize(Long invoiceId, Long productId, String size);
}
