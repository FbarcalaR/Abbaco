package abbaco.presentation.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import abbaco.entities.models.CashFlow;
import abbaco.presentation.dtoModels.CashFlowDto;

@Mapper(componentModel = "spring")
public interface CashFlowDtoEntityMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cashFlowClassifier.id", source = "classificationId")
    CashFlow CashFlowDtoToCashFlow(CashFlowDto source);
    
    @Mapping(source = "source.creationDate", target = "creationDate", dateFormat = "dd.MM.yyyy")
    @Mapping(target = "classificationId", source = "cashFlowClassifier.id")
    @Mapping(target = "classification", source = "cashFlowClassifier.name")
    CashFlowDto cashFlowToCashFlowDto(CashFlow source);


    Iterable<CashFlow> CashFlowDtoToCashFlow(Iterable<CashFlowDto> source);
    Iterable<CashFlowDto> cashFlowToCashFlowDto(Iterable<CashFlow> destination);
}