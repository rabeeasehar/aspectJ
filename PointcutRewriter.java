import java.util.Iterator;
	private Pointcut sortOrs(Pointcut pc) {
			SortedSet<Pointcut> nodes = new TreeSet<Pointcut>(new PointcutEvaluationExpenseComparator());
			collectOrNodes(pc, nodes);
			// write out with cheapest on left
			Iterator<Pointcut> iter = nodes.iterator();
			Pointcut result = iter.next();
			while (iter.hasNext()) {
				Pointcut right = iter.next();
				result = new OrPointcut(result, right);
			}
			return result;
		}