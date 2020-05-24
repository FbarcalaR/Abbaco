USE abbaco;

DROP TRIGGER IF EXISTS on_cashflows_insert;
CREATE TRIGGER on_cashflows_insert
  BEFORE INSERT ON cash_flow
  FOR EACH ROW
  SET new.id = uuid();
  
-- CREATE TRIGGER on_cashflowsclassifiers_insert
--   BEFORE INSERT ON cashflowsclassifiers 
--   FOR EACH ROW
--   SET new.id = uuid();