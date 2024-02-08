package fr.epita.assistants.seq;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.stream.*;

public interface Seq<T> extends ExtendedStream<T>{

    Stream<T> getStream();
    static <T> Seq<T> of(final List<T> values) {
        return () -> values.stream();
    }

    static <T> Seq<T> of(final T... values) {
        return () -> Arrays.stream(values);
    }

    static <T> Seq<T> of(final Stream<T> values) {
        return () -> values;
    }

    @Override
    default <KEY_TYPE> Map<KEY_TYPE, T> toMap(final Function<T, KEY_TYPE> keyMapper) {

        return toMap(new HashMap<>(), keyMapper, Function.identity());
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>> MAP_TYPE toMap(final MAP_TYPE map, final Function<T, KEY_TYPE> keyMapper, final Function<T, VALUE_TYPE> valueMapper) {
        List<T> elements = getStream().toList();
        for (T elt: elements)
        {
            map.put(keyMapper.apply(elt),valueMapper.apply(elt));
        }
        return map;
    }

    @Override
    default <KEY_TYPE, VALUE_TYPE> Map<KEY_TYPE, VALUE_TYPE> toMap(final Function<T, KEY_TYPE> keyMapper, final Function<T, VALUE_TYPE> valueMapper) {
        return toMap(new HashMap<>(), keyMapper, valueMapper);
    }

    @Override
    default List<T> toList() {
        return getStream().toList();
    }

    @Override
    default <LIST extends List<T>> LIST toList(final LIST list) {
        list.addAll(getStream().toList());
        return list;
    }

    @Override
    default Set<T> toSet() {

        return getStream().collect(Collectors.toSet());
    }

    @Override
    default <SET extends Set<T>> SET toSet(final SET set) {
        set.addAll(getStream().collect(Collectors.toSet()));
        return set;
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(final Supplier<ASSOCIATED_TYPE> supplier) {

        return of(getStream().map(e -> new Pair<>(e, supplier.get())));
    }

    @Override
    default <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(final Stream<ASSOCIATED_TYPE> supplier) {
        List<ASSOCIATED_TYPE> elements = supplier.toList();
        AtomicInteger index = new AtomicInteger();
        return of(getStream().limit(elements.size()).map(e -> new Pair<>(e, elements.get(index.getAndIncrement()))));
    }

    @Override
    default ExtendedStream<T> print()
    {
        System.out.println(getStream().toString());
        return this;
    }

    @Override
    default ExtendedStream<T> plus(final Stream<T> stream) {
        List<T> elements = new ArrayList<>(getStream().toList());
        List<T> added = stream.toList();
        elements.addAll(added);
        return Seq.of(elements.stream());
    }

    @Override
    default String join(final String delimiter) {
        List<T> list = getStream().toList();
        StringBuilder str = new StringBuilder();
        for (T t : list) {
            str.append(t.toString()).append(delimiter);
        }
        return str.substring(0, str.toString().length() - delimiter.length());
    }

    @Override
    default String join() {
        List<T> list = getStream().toList();
        StringBuilder str = new StringBuilder();
        for (T t : list) {
            str.append(t.toString());
        }
        return str.toString();
    }

    @Override
    default <KEY_TYPE> ExtendedStream<Pair<KEY_TYPE, ExtendedStream<T>>> partition(final Function<T, KEY_TYPE> pivot) {
            Map<KEY_TYPE, List<T>> m = new HashMap<>();
            List<T> elts = getStream().toList();
            for (T e: elts)
            {
                if (!m.containsKey(pivot.apply(e)))
                {
                    m.put(pivot.apply(e), new ArrayList<>());
                }
                m.get(pivot.apply(e)).add(e);
            }
            List<Pair<KEY_TYPE, ExtendedStream<T>>> res = new ArrayList<>();

            List<KEY_TYPE> keys = m.keySet().stream().toList();
            for (KEY_TYPE k: keys)
            {
                res.add(new Pair<>(k, of(m.get(k).stream())));
            }

            return Seq.of(res);
    }

    @Override
    default Stream<T> filter(Predicate<? super T> predicate) {
        return getStream().filter(predicate);
    }

    @Override
    default <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
        return getStream().map(mapper);
    }

    @Override
    default IntStream mapToInt(ToIntFunction<? super T> mapper) {
        return getStream().mapToInt(mapper);
    }

    @Override
    default LongStream mapToLong(ToLongFunction<? super T> mapper) {
        return getStream().mapToLong(mapper);
    }

    @Override
    default DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
        return getStream().mapToDouble(mapper);
    }

    @Override
    default <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
        return getStream().flatMap(mapper);
    }

    @Override
    default IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
        return getStream().flatMapToInt(mapper);
    }

    @Override
    default LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
        return getStream().flatMapToLong(mapper);
    }

    @Override
    default DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
        return getStream().flatMapToDouble(mapper);
    }

    @Override
    default Stream<T> distinct() {
        return getStream().distinct();
    }

    @Override
    default Stream<T> sorted() {
        return getStream().sorted();
    }

    @Override
    default Stream<T> sorted(Comparator<? super T> comparator) {
        return getStream().sorted(comparator);
    }

    @Override
    default Stream<T> peek(Consumer<? super T> action) {
        return getStream().peek(action);
    }

    @Override
    default Stream<T> limit(long maxSize) {
        return getStream().limit(maxSize);
    }

    @Override
    default Stream<T> skip(long n) {
        return getStream().skip(n);
    }

    @Override
    default void forEach(Consumer<? super T> action) {
        getStream().forEach(action);
    }

    @Override
    default void forEachOrdered(Consumer<? super T> action) {
        getStream().forEachOrdered(action);
    }

    @Override
    default Object[] toArray() {
        return getStream().toArray();
    }

    @Override
    default <A> A[] toArray(IntFunction<A[]> generator) {
        return getStream().toArray(generator);
    }

    @Override
    default T reduce(T identity, BinaryOperator<T> accumulator) {
        return getStream().reduce(identity, accumulator);
    }

    @Override
    default Optional<T> reduce(BinaryOperator<T> accumulator) {
        return getStream().reduce(accumulator);
    }

    @Override
    default <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
        return getStream().reduce(identity, accumulator, combiner);
    }

    @Override
    default <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
        return getStream().collect(supplier, accumulator, combiner);
    }

    @Override
    default <R, A> R collect(Collector<? super T, A, R> collector) {
        return getStream().collect(collector);
    }

    @Override
    default Optional<T> min(Comparator<? super T> comparator) {
        return getStream().min(comparator);
    }

    @Override
    default Optional<T> max(Comparator<? super T> comparator) {
        return getStream().max(comparator);
    }

    @Override
    default long count() {
        return getStream().count();
    }

    @Override
    default boolean anyMatch(Predicate<? super T> predicate) {
        return getStream().anyMatch(predicate);
    }

    @Override
    default boolean allMatch(Predicate<? super T> predicate) {
        return getStream().allMatch(predicate);
    }

    @Override
    default boolean noneMatch(Predicate<? super T> predicate) {
        return getStream().noneMatch(predicate);
    }

    @Override
    default Optional<T> findFirst() {
        return getStream().findFirst();
    }

    @Override
    default Optional<T> findAny() {
        return getStream().findAny();
    }

    @Override
    default Iterator<T> iterator() {
        return getStream().iterator();
    }

    @Override
    default Spliterator<T> spliterator() {
        return getStream().spliterator();
    }

    @Override
    default boolean isParallel() {
        return getStream().isParallel();
    }

    @Override
    default Stream<T> sequential() {
        return getStream().sequential();
    }

    @Override
    default Stream<T> parallel() {
        return getStream().parallel();
    }

    @Override
    default Stream<T> unordered() {
        return getStream().unordered();
    }

    @Override
    default Stream<T> onClose(Runnable closeHandler) {
        return getStream().onClose(closeHandler);
    }

    @Override
    default void close() {
        getStream().close();
    }
}
