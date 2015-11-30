package com.propero.feedService.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by farid on 26/11/15.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedData implements Serializable{


    @ApiModelProperty(notes = "The price", required = true)
    private String price;

    @ApiModelProperty(notes = "The dateTime", required = true)
    private String dateTime;

    @ApiModelProperty(notes = "The asset", required = true)
    private String asset;

}
