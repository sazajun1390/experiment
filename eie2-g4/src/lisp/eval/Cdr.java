package lisp.eval;

import lisp.exception.ArgumentException;
import lisp.exception.LispException;

public class Cdr implements Subroutine {
	private static final Cdr cdr = new Cdr();

	public static Cdr getInstance() {
		return cdr;
	}

	@Override
	public SExpression apply(SExpression sexp, Environment environment) throws LispException {
		if (!(sexp instanceof ConsCell)) {
			throw new ArgumentException("pair required, you input " + sexp);
		}
		int size = ((ConsCell) sexp).size();
		if (size != 1) {
			throw new ArgumentException(
					"wrong number of arguments for " + this + " (required 1, you input " + size + ")");
		}
		SExpression arg = ((ConsCell) sexp).get(0);
		if (!(arg instanceof ConsCell)) {
			throw new ArgumentException("pair required, you input " + arg);
		}
		return ((ConsCell) arg).getCdr();
	}

	@Override
	public String toString() {
		return "<subr cdr>";
	}
}