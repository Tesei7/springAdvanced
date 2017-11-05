package advanced.transactions;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class SampleDao {
    private PlatformTransactionManager txManager;

    public void someMethod(){
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setName("SomeTxName");
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_MANDATORY);
        def.setIsolationLevel(TransactionDefinition.ISOLATION_REPEATABLE_READ);

        TransactionStatus status = txManager.getTransaction(def);
        try {
// execute your business logic here
        }
        catch (Exception ex) {
            txManager.rollback(status);
            throw ex;
        }
        txManager.commit(status);
    }
}
