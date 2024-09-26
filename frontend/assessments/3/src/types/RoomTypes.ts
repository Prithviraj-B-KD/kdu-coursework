export interface RoomTypes {
  roomTypes: RoomType[];
}

export interface RoomType {
  id: number;
  name: string;
  costPerNight: string;
  currency: string;
  addOns: AddOn[];
}

export interface AddOn {
  name: string;
  cost: string;
  currency: string;
}
