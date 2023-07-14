package com.nickgonzalez.trainhsr.pojo;

import com.nickgonzalez.trainhsr.entity.Train;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Data
@Validated
public class Trip {
    private List<Integer> trainIds = new ArrayList<Integer>();
    private String customerName;
}
