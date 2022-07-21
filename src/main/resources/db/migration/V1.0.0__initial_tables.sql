CREATE TABLE public.register_item(
    id serial PRIMARY KEY,
    item_id varchar UNIQUE,
    counting numeric NOT NULL
);

CREATE INDEX register_item_indx1 ON public.register_item(counting);