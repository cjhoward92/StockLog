package com.stocklog.stocklog.data;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
public class AssetType {

    private static final long serialVersionUID = 3489483290483290L;

    private Long id;
    private String name;
}
