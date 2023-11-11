package com.proyectoh.pc2.domain.service;

import com.proyectoh.pc2.domain.model.InvoiceDetail;

import java.util.List;

public interface InvoiceDetailService {
    InvoiceDetail create(InvoiceDetail invoiceDetail);
    List<InvoiceDetail> getAll();

}
