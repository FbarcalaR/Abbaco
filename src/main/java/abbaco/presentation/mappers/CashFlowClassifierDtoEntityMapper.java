package abbaco.presentation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import abbaco.entities.models.CashFlowClassifier;
import abbaco.presentation.dtoModels.CashFlowClassifierDto;

@Mapper(componentModel = "spring")
public interface CashFlowClassifierDtoEntityMapper {
    

    @Mapping(target = "id", ignore = true)
    CashFlowClassifier CashFlowClassifierDtoToCashFlowClassifier(CashFlowClassifierDto source);

    CashFlowClassifierDto cashFlowClassifierToCashFlowClassifierDto(CashFlowClassifier source);


    Iterable<CashFlowClassifier> CashFlowClassifierDtoToCashFlowClassifier(Iterable<CashFlowClassifierDto> source);
    Iterable<CashFlowClassifierDto> cashFlowClassifierToCashFlowClassifierDto(Iterable<CashFlowClassifier> destination);
}