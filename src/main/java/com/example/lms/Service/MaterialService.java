package com.example.lms.Service;

import com.example.lms.Model.Material;
import com.example.lms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MaterialService {

    ArrayList<Material> materials = new ArrayList<>();

    public ArrayList<Material> getMaterials() {
        return materials;
    }

    public void addMaterial(Material material)
    {
        materials.add(material);
    }

    public boolean updateMaterial(String id, Material material)
    {
        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getId().equals(id))
            {
                materials.set(i,material);
                return true;
            }
        }
        return false;
    }

    public boolean deleteMaterial(String id)
    {
        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getId().equals(id))
            {
                materials.remove(i);
                return true;
            }
        }
        return false;
    }

    public Material searchById(String id)
    {
        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getId().equals(id))
            {
                return materials.get(i);
            }
        }
        return null;
    }

    public ArrayList<Material> getByLevel(String level)
    {
        ArrayList<Material> materials1 = new ArrayList<>();

        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getLevel().equals(level))
            {
                materials1.add(materials.get(i));
            }
        }
        return materials1;
    }

    public boolean deleteByType(String type)
    {
        boolean check = false;
        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getType().equals(type))
            {
                materials.remove(i);
                check = true;
            }
        }
        return check;
    }

    public int countOfLevel(String level)
    {
        int count = 0;
        for (int i = 0; i < materials.size(); i++) {
            if(materials.get(i).getLevel().equals(level))
            {
                count++;
            }
        }
        return count;
    }
}
