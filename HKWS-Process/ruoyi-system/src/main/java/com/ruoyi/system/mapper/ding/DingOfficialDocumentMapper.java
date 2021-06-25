package com.ruoyi.system.mapper.ding;

import com.ruoyi.system.domain.HkOfficialDocument;

import java.util.List;

/**
 * @ProjectName: ruoyi
 * @Package: com.ruoyi.system.mapper.ding
 * @ClassName: DingOfficialDocumentMapper
 * @Author: guohailong
 * @Description: 浙政钉-公文
 * @Date: 2021/3/10 20:56
 * @Version: 1.0
 */
public interface DingOfficialDocumentMapper {
    List<HkOfficialDocument> getDocumentList();

    HkOfficialDocument getDocumentDetail(Long id);
}
