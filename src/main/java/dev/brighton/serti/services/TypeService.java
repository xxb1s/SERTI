package dev.brighton.serti.services;

import dev.brighton.serti.dtos.TypeDTO;
import dev.brighton.serti.entities.Type;
import dev.brighton.serti.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;

    public TypeDTO save(TypeDTO typeDTO) {
        Type type = new Type();
        type.setName(typeDTO.getName());
        type.setApiId(typeDTO.getApiId());

        typeRepository.save(type);
        return convertTypeToDTO(type);
    }

    public TypeDTO getTypeById(Long id) {
        Optional<Type> typeOpt = typeRepository.findById(id);

        if (typeOpt.isPresent()) {
            return convertTypeToDTO(typeOpt.get());
        }

        return new TypeDTO();
    }

    public TypeDTO convertTypeToDTO(Type type) {
        return new TypeDTO(type.getId(), type.getName(), type.getApiId());
    }
}
