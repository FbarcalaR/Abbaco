package abbaco.presentation.mappers;

import org.mapstruct.Mapper;

import abbaco.entities.models.CashFlow;
import abbaco.presentation.dtoModels.CashFlowDto;

@Mapper(componentModel = "spring")
public interface CashFlowDtoEntityMapper {
    CashFlow CashFlowDtoToCashFlow(CashFlowDto source);
    CashFlowDto cashFlowToCashFlowDto(CashFlow destination);


    Iterable<CashFlow> CashFlowDtoToCashFlow(Iterable<CashFlowDto> source);
    Iterable<CashFlowDto> cashFlowToCashFlowDto(Iterable<CashFlow> destination);
}