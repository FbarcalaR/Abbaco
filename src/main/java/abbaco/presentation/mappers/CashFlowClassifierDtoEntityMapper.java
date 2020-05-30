package abbaco.presentation.mappers;

import org.mapstruct.Mapper;

import abbaco.entities.models.CashFlowClassifier;
import abbaco.presentation.dtoModels.CashFlowClassifierDto;

@Mapper(componentModel = "spring")
public interface CashFlowClassifierDtoEntityMapper {
    CashFlowClassifier CashFlowClassifierDtoToCashFlowClassifier(CashFlowClassifierDto source);
    CashFlowClassifierDto cashFlowClassifierToCashFlowClassifierDto(CashFlowClassifier destination);


    Iterable<CashFlowClassifier> CashFlowClassifierDtoToCashFlowClassifier(Iterable<CashFlowClassifierDto> source);
    Iterable<CashFlowClassifierDto> cashFlowClassifierToCashFlowClassifierDto(Iterable<CashFlowClassifier> destination);
}