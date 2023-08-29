package vega.com.backend.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vega.com.backend.common.JobTag;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;

    private String name;

    private JobTag job;
}
