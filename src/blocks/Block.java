package blocks;

import exception.WorkflowException;

import java.util.List;

public interface Block {

    List<String> execute(List<String> text, String[] args) throws WorkflowException;

}