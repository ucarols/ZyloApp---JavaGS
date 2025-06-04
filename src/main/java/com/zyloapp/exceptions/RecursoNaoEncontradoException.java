package com.zyloapp.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class RecursoNaoEncontradoException extends EntityNotFoundException {
    public RecursoNaoEncontradoException(String msg) { super(msg); }
}
