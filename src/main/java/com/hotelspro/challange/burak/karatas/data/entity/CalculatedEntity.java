package com.hotelspro.challange.burak.karatas.data.entity;

import com.hotelspro.challange.burak.karatas.models.enums.CalculateType;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bkaratas on 08.05.2017.
 */
public class CalculatedEntity implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    private Long calculatedId;

    @NotEmpty
    @NotNull
    private Double operationParam1;

    @NotEmpty
    @NotNull
    private Double operationParam2;

    @NotEmpty
    @NotNull
    private CalculateType calculateType;

    @NotEmpty
    @NotNull
    private Double operationResult;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date processDate;

    public CalculatedEntity() {
    }


    public Long getCalculatedId() {
        return calculatedId;
    }

    public void setCalculatedId(Long calculatedId) {
        this.calculatedId = calculatedId;
    }

    public Double getOperationParam1() {
        return operationParam1;
    }

    public void setOperationParam1(Double operationParam1) {
        this.operationParam1 = operationParam1;
    }

    public Double getOperationParam2() {
        return operationParam2;
    }

    public void setOperationParam2(Double operationParam2) {
        this.operationParam2 = operationParam2;
    }

    public CalculateType getCalculateType() {
        return calculateType;
    }

    public void setCalculateType(CalculateType calculateType) {
        this.calculateType = calculateType;
    }

    public Double getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(Double operationResult) {
        this.operationResult = operationResult;
    }
}
