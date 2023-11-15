package ${package_mapper};

import ${package_pojo}.${Table};
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

/**
 * ${tableComment} Mapper
 * ${TableName}
 *
 * @Author: ${Table}构建
 * @Description: ${Table}构建
 * @Date ${time}
 */
public interface ${Table}Mapper extends Mapper<${Table}> {

    int addBatch(@Param("list") List<${Table}> list);

}
