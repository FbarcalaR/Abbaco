USE abbaco;

CREATE TRIGGER on_cashflows_insert
  BEFORE INSERT ON cashflows 
  FOR EACH ROW
  SET new.id = uuid();
  
CREATE TRIGGER on_cashflowsclassifiers_insert
  BEFORE INSERT ON cashflowsclassifiers 
  FOR EACH ROW
  SET new.id = uuid();