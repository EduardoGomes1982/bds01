package com.devsuperior.bds01.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.repositories.DepartmentRepository;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;
    
    @Transactional(readOnly = true)
    public List<DepartmentDTO> findAll() {
        return repository.findAll(Sort.by("name")).stream().map(e -> new DepartmentDTO(e)).toList();
    }
}
