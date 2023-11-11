package com.proyectoh.pc2.api.rest;

import com.proyectoh.pc2.domain.model.InvoiceDetail;
import com.proyectoh.pc2.domain.service.InvoiceDetailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/v1/invoicedetails")
public class InvoiceDetailController {

    private  final InvoiceDetailService invoiceDetailService;

    public InvoiceDetailController(InvoiceDetailService invoiceDetailService) {
        this.invoiceDetailService = invoiceDetailService;
    }

    @GetMapping
    public List<InvoiceDetail> getAllUsers() {
        return  invoiceDetailService.getAll();
    }

    @PostMapping
    public InvoiceDetail createInvoiceDetail(@RequestBody InvoiceDetail invoiceDetail) {
        return invoiceDetailService.create(invoiceDetail);
    }

}
