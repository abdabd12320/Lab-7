package com.example.lms.Controller;

import com.example.lms.ApiResponse.MaterialApiResponse;
import com.example.lms.ApiResponse.StudentApiResponse;
import com.example.lms.Model.Material;
import com.example.lms.Model.Student;
import com.example.lms.Service.MaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/material")
@RequiredArgsConstructor
public class MaterialController {

    private final MaterialService materialService;

    @GetMapping("/get")
    public ResponseEntity getMaterial()
    {
        return ResponseEntity.status(200).body(materialService.getMaterials());
    }
    @PostMapping("/add")
    public ResponseEntity addMaterial(@Valid @RequestBody Material material, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        materialService.addMaterial(material);
        return ResponseEntity.status(200).body(new MaterialApiResponse("Material added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateMaterial(@PathVariable String id,@Valid@RequestBody Material material,Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(materialService.updateMaterial(id, material))
        {
            return ResponseEntity.status(200).body(new MaterialApiResponse("Material updated"));
        }
        return ResponseEntity.status(400).body(new MaterialApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteMaterial(@PathVariable String id)
    {
        if(materialService.deleteMaterial(id))
        {
            return ResponseEntity.status(200).body(new MaterialApiResponse("Material deleted"));
        }
        return ResponseEntity.status(400).body(new MaterialApiResponse("not found"));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchById(@PathVariable String id)
    {
        if(materialService.searchById(id) == null)
        {
            return ResponseEntity.status(400).body(new MaterialApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(materialService.searchById(id));
    }
    @GetMapping("/get-by-level/{level}")
    public ResponseEntity getByLevel(@PathVariable String level)
    {
        if(materialService.getByLevel(level).isEmpty())
        {
            return ResponseEntity.status(400).body(new MaterialApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(materialService.getByLevel(level));
    }
    @DeleteMapping("/delete-by-type/{type}")
    public ResponseEntity deleteByType(@PathVariable String type)
    {
        if(!materialService.deleteByType(type))
        {
            return ResponseEntity.status(400).body(new MaterialApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(new MaterialApiResponse("type deleted"));
    }
    @GetMapping("/count-of-level/{level}")
    public ResponseEntity countOfLevel(@PathVariable String level)
    {
        return ResponseEntity.status(200).body(new MaterialApiResponse("Count of level is " + materialService.countOfLevel(level)));
    }

}
