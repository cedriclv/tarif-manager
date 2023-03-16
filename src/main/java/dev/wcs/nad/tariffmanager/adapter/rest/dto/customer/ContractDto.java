package dev.wcs.nad.tariffmanager.adapter.rest.dto.customer;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ContractDto {

    private String tariff;
    private List<String> options;

}
