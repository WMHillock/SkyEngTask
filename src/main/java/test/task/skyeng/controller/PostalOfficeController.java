package test.task.skyeng.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.task.skyeng.entity.PostalOfficeEntity;
import test.task.skyeng.service.PostalOfficeService;

@RestController
@RequestMapping("/postal-offices")
public class PostalOfficeController {


    private final PostalOfficeService postalOfficeService;
    @Autowired
    public PostalOfficeController (PostalOfficeService postalOfficeService) {
        this.postalOfficeService = postalOfficeService;
    }

    @Operation(summary = "Создание офиса")
    @PostMapping
    public ResponseEntity<PostalOfficeEntity> createPostalOffice(@RequestBody PostalOfficeEntity postalOffice) {
        PostalOfficeEntity createdPostalOffice = postalOfficeService.createPostalOffice(postalOffice);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPostalOffice);
    }

    @Operation(summary = "Просмотр офиса по ID")
    @GetMapping("/{id}")
    public ResponseEntity<PostalOfficeEntity> getPostalOfficeById(@PathVariable Long id) {
        PostalOfficeEntity postalOffice = postalOfficeService.getPostalOfficeById(id);
        return ResponseEntity.ok(postalOffice);
    }

    @Operation(summary = "Просмотр офиса по индексу")
    @GetMapping("/by-index/{index}")
    public ResponseEntity<PostalOfficeEntity> getPostalOfficeByIndex(@PathVariable String index) {
        PostalOfficeEntity postalOffice = postalOfficeService.getPostalOfficeByIndex(index);
        return ResponseEntity.ok(postalOffice);
    }
}

