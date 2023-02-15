package nus.iss.tfip.pafday28.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nus.iss.tfip.pafday28.model.Category;
import nus.iss.tfip.pafday28.repository.AppRepository;

@Service
public class AppService {
    @Autowired AppRepository appRepo;

    public List<Category> sortAppsByCategory() {
        return appRepo.sortAppsByCategory()
                .stream()
                .map(v -> Category.toCategory(v))
                .toList();
    }
}
