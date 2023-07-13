package com.nickgonzalez.trainhsr.pojo;

import com.nickgonzalez.trainhsr.entity.Train;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trip {
    private List<Integer> trainIds;
}
