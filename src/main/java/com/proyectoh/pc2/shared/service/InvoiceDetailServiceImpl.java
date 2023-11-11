package com.proyectoh.pc2.shared.service;

import com.proyectoh.pc2.domain.model.InvoiceDetail;
import com.proyectoh.pc2.domain.persistence.InvoiceDetailRepository;
import com.proyectoh.pc2.domain.service.InvoiceDetailService;
import com.proyectoh.shared.exceptions.ResourceValidationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {

    private final InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetailServiceImpl(InvoiceDetailRepository invoiceDetailRepository) {
        this.invoiceDetailRepository = invoiceDetailRepository;
    }

    @Override
    public InvoiceDetail create(InvoiceDetail invoiceDetail) {
        validateInvoiceDetail(invoiceDetail);
        return invoiceDetailRepository.save(invoiceDetail);
    }

    @Override
    public List<InvoiceDetail> getAll() {
        return invoiceDetailRepository.findAll();
    }

    private void validateInvoiceDetail(InvoiceDetail invoiceDetail) {

        if (invoiceDetailRepository.existsByInvoiceIdAndProductId(invoiceDetail.getInvoiceId(), invoiceDetail.getProductId())) {
            throw new ResourceValidationException("Ya existe un InvoiceDetail con la misma combinación de invoiceId y productId.");
        }

        if (invoiceDetail.getColor() != null &&
                invoiceDetailRepository.existsByInvoiceIdAndProductIdAndColor(invoiceDetail.getInvoiceId(), invoiceDetail.getProductId(), invoiceDetail.getColor())) {
            throw new ResourceValidationException("Ya existe un InvoiceDetail con la misma combinación de invoiceId, productId y color.");
        }

        if (invoiceDetail.getSize() != null &&
                invoiceDetailRepository.existsByInvoiceIdAndProductIdAndSize(invoiceDetail.getInvoiceId(), invoiceDetail.getProductId(), invoiceDetail.getSize())) {
            throw new ResourceValidationException("Ya existe un InvoiceDetail con la misma combinación de invoiceId, productId y size.");
        }
    }
}

