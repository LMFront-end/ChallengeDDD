package co.com.sofka.challengeDDD.domain.ventaelectronica.commands;

import co.com.sofka.challengeDDD.domain.ventaelectronica.ids.CanalDePagoId;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.CanalPagoProveedor;
import co.com.sofka.challengeDDD.domain.ventaelectronica.valueobjects.PoliticaDeRetiro;
import co.com.sofka.domain.generic.Command;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CrearCanalDePago extends Command {

    private final CanalDePagoId canalDePagoId;
    private final CanalPagoProveedor canalPagoProveedor;
    private final PoliticaDeRetiro politicaDeRetiro;

}
