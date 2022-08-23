package lordbyron.support.Shared;

import org.springframework.stereotype.Service;
@Service
public class MethodsServiceImpl implements MethodsService {

    @Override
    public String generateNewId(Long count,String productType, String  lastId) {
        String newId,newNum = "";
       var prefix = "LB-"+productType;
        if (count == 0) {
            newId=prefix+"-001";
        }else {
            long num = Long.parseLong(lastId.substring(lastId.length() - 3));
            if (num <= 8) {
                newNum = "-00" + (num + 1);
            }
            if (num >= 9 && num < 99) {
                newNum = "-0" + (num + 1);
            }
            if (num >= 99) {
                newNum ="-"+(num + 1);
            }
            newId =prefix+newNum;
        }
        return newId;
    }
}
