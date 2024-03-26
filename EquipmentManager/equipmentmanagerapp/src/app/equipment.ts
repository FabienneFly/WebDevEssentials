export class Equipment {
    id?: number;
    name?: string;
    description?: string;
    amount?: number;
    equipmentCode?: string;


    constructor(id?: number, name?: string, description?: string, amount?: number, equipmentCode?: string) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.amount = amount;
    this.equipmentCode = equipmentCode;
}
}