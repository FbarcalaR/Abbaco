package abbaco.presentation.mappers;

import org.mapstruct.Mapper;

import abbaco.presentation.dtoModels.CashFlowFiltersDto;
import abbaco.usecases.CashFlowFiltersSvc;

@Mapper(componentModel = "spring")
public interface CashFlowFiltersDtoSvcMapper {
    
    CashFlowFiltersSvc cashFlowFiltersDtoToCashFlowFiltersSvc(CashFlowFiltersDto source);
}