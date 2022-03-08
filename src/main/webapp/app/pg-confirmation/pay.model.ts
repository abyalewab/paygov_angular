export interface IPay {
  id?: number;
  cik?: number | null;
  ccc?: number | null;
  paymentAmount?: number | null;
  name?: string | null;
  email?: string | null;
  phone?: string | null;
  approvalStatus?: string | null;
}
